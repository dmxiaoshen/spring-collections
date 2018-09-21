package com.codingapi.tx;

import com.codingapi.tx.config.service.TxManagerTxUrlService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * create by lorne on 2017/11/18
 */
public class TxManagerTxUrlServiceImpl implements TxManagerTxUrlService {

    private TxManagerProperity properity;

    public TxManagerTxUrlServiceImpl(TxManagerProperity properity){
        this.properity = properity;
    }

    @Override
    public String getTxUrl() {
        System.out.println("load tm.manager.url ");
        return properity.getUrl();
    }
}
