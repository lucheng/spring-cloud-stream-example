package com.cheng.stream.producer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.cheng.stream.utils.DateUtil;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class JavaConfig {

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		// 1、创建FastJson信息转换对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		// 2、创建FastJsonConfig对象并设定序列化规则 序列化规则详见SerializerFeature类中，后面会讲
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
				SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteNonStringKeyAsString,
				SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteMapNullValue);

		fastJsonConfig.setSerializeFilters((ValueFilter) (o, s, source) -> {
			if (source instanceof LocalDateTime) {
				return DateUtil.formatDatetime((LocalDateTime)source);
			}
			return source;
		});

//		fastJsonConfig.getSerializeConfig().put(LocalDateTime.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
		
		// 3、中文乱码解决方案,此处可添加能够解析的多种类型
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(fastMediaTypes);
		// 4、将转换规则应用于转换对象
		fastConverter.setFastJsonConfig(fastJsonConfig);
		return new HttpMessageConverters(fastConverter);
	}
}