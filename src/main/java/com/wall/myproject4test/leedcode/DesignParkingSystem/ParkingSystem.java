package com.wall.myproject4test.leedcode.DesignParkingSystem;


/** 
* @Description: 1603. Design Parking System
 * Input
 * ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 * [[1, 1, 0], [1], [2], [3], [1]]
 * Output
 * [null, true, true, false, false]
* @Author: zhang.zw
* @Date: 2021/11/3 
*/
public class ParkingSystem {

    private Integer big;
    private Integer medium;
    private Integer small;
    private Integer initBig;
    private Integer initMedium;
    private Integer initSmall;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
        initBig = 0;
        initMedium = 0;
        initSmall = 0;
    }

    public boolean addCar(int carType) {
        boolean ans = false;
        switch (carType){
            case 1:
                if(initBig<big){
                    initBig++;
                    ans=true;
                }else {
                    ans = false;
                }
                break;
            case 2:
                if(initMedium<medium){
                    initMedium++;
                    ans=true;
                }else {
                    ans = false;
                }
                break;
            case 3:
                if(initSmall<small){
                    initSmall++;
                    ans=true;
                }else {
                    ans = false;
                }
                break;
            default:
                break;
        }
        return ans;
    }
}
