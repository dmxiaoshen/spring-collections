package com.dmxiaoshen.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.dmxiaoshen.dao.RecordDao;
import com.dmxiaoshen.model.Record;
import com.dmxiaoshen.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hzhsg on 2018/9/20.
 */
@Service
public class RecordServiceImpl implements RecordService{
    @Autowired
    private RecordDao recordDao;
    @Override
    @Transactional
    @TxTransaction
    public int add(Record record) {
        return recordDao.insert(record.getProductName(),record.getUserName(),record.getMoney());
    }
}
