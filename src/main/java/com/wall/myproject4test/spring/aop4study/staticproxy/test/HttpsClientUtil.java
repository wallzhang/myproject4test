/**
 * @Title: HttpsClientUtil.java
 * @Package ssa.tel.service.http
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 张首举
 * @date 2018年5月23日 下午4:47:23
 * @version V1.0
 */

package com.wall.myproject4test.spring.aop4study.staticproxy.test;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.calcite.avatica.org.apache.http.config.Registry;
import org.apache.calcite.avatica.org.apache.http.config.RegistryBuilder;
import org.apache.calcite.avatica.org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.calcite.avatica.org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.calcite.avatica.org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.calcite.avatica.org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Map;

@Slf4j
public class HttpsClientUtil {

    public static String post(String url, String params, Map<String, String> header) {
        log.debug("postUrl:" + url + "----------params:" + params);

        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = "";
        try {
			SSLContext sslcontext = createIgnoreVerifySSL();
			//设置协议http和https对应的处理socket链接工厂的对象
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("http", PlainConnectionSocketFactory.INSTANCE)
					.register("https", new SSLConnectionSocketFactory(sslcontext))
					.build();
			PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			HttpClients.custom().setConnectionManager((HttpClientConnectionManager) connManager);
            httpClient = HttpClients.custom().setConnectionManager((HttpClientConnectionManager) connManager).build();
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).build();
            httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            dealHeader(httpPost, header);
            //如果指定编码，这里要进行编码处理
            StringEntity entity = new StringEntity(params, "utf-8");
            entity.setContentEncoding("UTF-8");
            //如果不指定，默认编码
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            result = EntityUtils.toString(httpEntity, "utf-8");
            log.debug("post result:" + result);
        } catch (Exception e) {
            log.error("postUrl[" + url + "] error:", e);
            result = "";
        } finally {
            try {
                if (httpPost != null) {
                    httpPost.releaseConnection();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                result = "";
            }
        }
        return result;
    }

    public static String getUrl(String url, Map<String, String> header) {
        log.debug("getUrl:" + url);
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;

        String result;
        try {
			SSLContext sslcontext = createIgnoreVerifySSL();
			//设置协议http和https对应的处理socket链接工厂的对象
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("http", PlainConnectionSocketFactory.INSTANCE)
					.register("https", new SSLConnectionSocketFactory(sslcontext))
					.build();
			PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			HttpClients.custom().setConnectionManager((HttpClientConnectionManager) connManager);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).build();
            httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);
            dealHeader(httpGet, header);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            result = EntityUtils.toString(httpEntity, "utf-8");
            log.debug("get result:" + result);
            if (result.startsWith("{")) {
                JSONObject json = JSONObject.parseObject(result);
                log.debug("get result json:" + json);
            }
        } catch (Exception e) {
            log.error("getUrl:[" + url + "] error", e);
            result = "";
        } finally {
            try {
                if (httpGet != null) {
                    httpGet.releaseConnection();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                result = "";
            }
        }
        return result;
    }

    private static void dealHeader(Object httpMethod, Map<String, String> header) {
        if (null != header && header.size() > 0) {
            for (String key : header.keySet()) {
                if (httpMethod instanceof HttpPost) {
                    ((HttpPost) httpMethod).setHeader(key, header.get(key));
                } else if (httpMethod instanceof HttpGet) {
                    ((HttpGet) httpMethod).setHeader(key, header.get(key));
                } else {
                    throw new RuntimeException("unknow class type!");
                }
            }
        }
    }


    /**
     * 绕过验证
     *
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSLv3");

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        sc.init(null, new TrustManager[]{trustManager}, null);
        return sc;
    }

}
