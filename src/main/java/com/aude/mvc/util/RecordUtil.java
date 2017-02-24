package com.aude.mvc.util;

import com.aude.mvc.cache.MvcsManager;
import com.aude.mvc.dao.bean.TableInfo;
import com.aude.mvc.dao.entity.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/12/30 0030
 * To change this template use File | Settings | File Templates.
 */
public class RecordUtil {

    public static <E> List<E> toEntity(Class klass, List<Record> records) throws Exception {
        TableInfo tableInfo = (TableInfo) MvcsManager.getTableCache(klass.getName());
        List<E> E = new ArrayList<>();
        for (Record record : records) {
            E.add(DBUtil.RecordToEntity(klass, tableInfo, record));
        }
        return E;
    }
}
