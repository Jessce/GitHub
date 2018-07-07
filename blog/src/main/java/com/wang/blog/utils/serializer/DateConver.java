package com.wang.blog.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 0:29 2018/7/1
 * @ Description：日期转换器：格式化日期显示格式：yyyy-MM-dd HH:mm:ss
 * @ Modified By：
 */
public class DateConver extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonGenerator.writeString( simpleDateFormat.format(date));
    }
}
