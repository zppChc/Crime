package com.chc.criminalintent.database;

/**
 * DESC:
 * Author: CHC
 * Date: 2017/12/8
 */

public class CrimeDbSchema {
    public static final class CrimeTable{
        //唯一的用途就是定义描述数据表元素的String常量。首先要定义的是数据库表名
        public static final String NAME = "crimes";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
            public static final String SUSPECT = "suspect";
        }
    }
}
