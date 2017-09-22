package com.womow.henan.commons.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PropertiesLoader {

	private final Properties properties;
	private static Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

	public PropertiesLoader(String...resourcePaths) {
		properties = loadProperties(resourcePaths);
	}
	
	/**
	 * 根据路径读取properties文件
	 * @param resourcePaths 文件路径
	 */
	private Properties loadProperties(String[] resourcePaths) {
		Properties props = new Properties();
		if (resourcePaths != null && resourcePaths.length > 0) {
			for (String path : resourcePaths) {
				InputStreamReader io = null; 
				try {
					io = new InputStreamReader(PropertiesLoader.
							class.getClassLoader().getResourceAsStream(path),"UTF-8");
					props.load(io);
				} catch (Exception e) {
					logger.error("PropertiesLoader.loadProperties()异常 "+path, e);
				} finally {
					if (io != null) {
						try {
							io.close();
						} catch (IOException e) {
						}
					}
				}
			}
		}
		return props;
	}
	
	/**
	 * 根据键获取值
	 * @param key 键
	 * @return
	 */
	public String getConfig(String key) {
		if (properties.containsKey(key)) {
			return properties.getProperty(key);
		}
		return "";
	}
}
