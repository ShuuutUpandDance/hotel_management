package com.zjl.test;

import com.zjl.factory.BeanFactory;
import com.zjl.service.IDinnerTableService;
import org.junit.jupiter.api.Test;

public class testTableService {
    private IDinnerTableService dinnerTableService = BeanFactory.getInstance("dinnerTableService", IDinnerTableService.class);

    @Test
    public void testOrder() {
        dinnerTableService.order(1);
    }

    @Test
    public void testCancel() {
        dinnerTableService.cancelOrder(1);
    }
}
