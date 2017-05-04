package com.qchery.kada.builder;

import java.util.List;

import com.qchery.kada.utils.StringUtil;
import com.qchery.kada.Item;
import com.qchery.kada.ObjectDescriptor;
import com.qchery.kada.utils.XMLUtil;
import com.qchery.kada.model.ibatis.Mapper;
import com.qchery.kada.model.ibatis.Result;
import com.qchery.kada.model.ibatis.ResultMap;

/**
 * Mybatis配置文件建造器
 *
 * @author Chery
 * @date 2016年5月15日 - 下午9:24:22
 */
public class MybatisBuilder implements FileBuilder {

    /**
     * <mapper namespace="cn.chery.cmail.antispam.dao.AsHoneypotDao">
     *     <resultMap type="asHoneypot" id="FullResultMap">
     *         <id property="honeypotId" column="honeypot_id"/>
     *         <result property="emailAddr" column="email_addr"/>
     *     </resultMap>
     * </mapper>
     */
    @Override
    public String getContent(ObjectDescriptor descriptor) {
        Mapper mapper = new Mapper(String.format("%s.%sDao",
                descriptor.getPackageName(), descriptor.getClassName()));
        ResultMap resultMap = new ResultMap("FullResultMap",
                StringUtil.lowerFirstChar(descriptor.getClassName()));
        List<Item> items = descriptor.getItems();
        for (Item item : items) {
            Result result = new Result(item.getFieldName(), item.getColumnName());
            if (item.isPK()) {
                resultMap.addId(result);
            } else {
                resultMap.addResult(result);
            }
        }
        mapper.setResultMap(resultMap);
        String content = XMLUtil.toXML(mapper);
        content = "<?xml version=\"1.0\" encoding=\"" + descriptor.getCharset().name() + "\" ?>\n" +
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n" + content;
        return content;
    }

    @Override
    public String getFileName(String className) {
        return className + "Dao.xml";
    }

}