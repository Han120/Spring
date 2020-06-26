package com.ahut.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author hanzijian
 * @create 2020-06-26 16:53
 */
public class DateTypeHandler extends BaseTypeHandler<String> {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //将java类型转换成数据库需要的类型

    @Override
    public void setNonNullParameter(PreparedStatement pPreparedStatement, int pI, String pS, JdbcType pJdbcType) throws SQLException {

        try {
            if(pI==4) {
                Date date = simpleDateFormat.parse(pS);
                long time = date.getTime();
                pPreparedStatement.setLong(pI, time);
            }
            else {
                pPreparedStatement.setString(pI, pS);
            }
        } catch (ParseException pE) {
            pE.printStackTrace();
        }


    }

    //将数据库的类型转换成java需要的类型
    //string参数 数据库要转换的字段名称
    //resultset 查询出的结果集
    @Override
    public String getNullableResult(ResultSet pResultSet, String pS) throws SQLException {
        //获得结果集中需要的数据(long)，将其转换成data类型，返回
        long aLong = pResultSet.getLong(pS);
        Date date = new Date(aLong);
        String strDate=simpleDateFormat.format(date);

        return strDate;
    }

    //将数据库的类型转换成java需要的类型
    @Override
    public String getNullableResult(ResultSet pResultSet, int pI) throws SQLException {

        long aLong = pResultSet.getLong(pI);
        Date date = new Date(aLong);
        String strDate=simpleDateFormat.format(date);

        return strDate;
    }

    //将数据库的类型转换成java需要的类型
    @Override
    public String getNullableResult(CallableStatement pCallableStatement, int pI) throws SQLException {
        long aLong = pCallableStatement.getLong(pI);
        Date date = new Date(aLong);
        String strDate=simpleDateFormat.format(date);

        return strDate;
    }
}
