package com.hajni.libjava;

public class ObjectParamTest {

    ObjParam obj;

    void setObj(ObjParam new_Obj){
        obj = new_Obj;
        obj.print();
    }
    ObjParam getObj(){
        obj.str = "return ObjParam";
        return obj;
    }
}
