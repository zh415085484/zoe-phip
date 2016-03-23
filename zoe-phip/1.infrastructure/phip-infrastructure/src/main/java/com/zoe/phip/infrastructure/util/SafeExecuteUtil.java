package com.zoe.phip.infrastructure.util;

import com.zoe.phip.infrastructure.entity.LogMessage;
import com.zoe.phip.infrastructure.exception.BusinessException;
import com.zoe.phip.infrastructure.function.Function;
import com.zoe.phip.infrastructure.entity.Message;
import com.zoe.phip.infrastructure.entity.ServiceResult;
import com.zoe.phip.infrastructure.entity.ServiceResultT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwenbin on 2016/2/29.
 */
public final class SafeExecuteUtil<T> {

    private static final Logger logger = LoggerFactory.getLogger(SafeExecuteUtil.class);

    public static ServiceResult execute(Function<Object> invoker) {
        ServiceResult executeResult = new ServiceResult();
        try {
            Object result = invoker.apply();
            executeResult.setIsSuccess(result != null);
        } catch (BusinessException ex) {
            //日志消息
            executeResult.addMessage("", ex.getMessage());
            executeResult.setIsSuccess(false);
            logger.error(ex.getMessage());
        } catch (Exception e) {
            //错误消息
            executeResult.setIsSuccess(false);
            executeResult.addLogData(e.toString());
            executeResult.addLogData(getStackMsg(e));
            logger.error("方法执行报错:", e);
        }
        return executeResult;
    }

    public ServiceResultT<T> executeT(Function<Object> invoker) {
        ServiceResultT<T> executeResult = new ServiceResultT<T>();
        try {
            T result = (T) invoker.apply();
            executeResult.setResult(result);
            executeResult.setIsSuccess(result != null);
        } catch (BusinessException ex) {
            //日志消息
            //todo 如何定义错误ID
            executeResult.addMessage("1001", ex.getMessage());
            executeResult.setIsSuccess(false);
            logger.error(ex.getMessage());
        } catch (Exception e) {
            executeResult.setIsSuccess(false);
            executeResult.addLogData(e.toString());
            executeResult.addLogData(getStackMsg(e));
            logger.error("方法执行报错:", e);
        }
        return executeResult;
    }

    private static String getStackMsg(Exception e) {

        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stackArray = e.getStackTrace();
        for (int i = 0; i < stackArray.length; i++) {
            StackTraceElement element = stackArray[i];
            String msg = element.toString();
            if (msg.startsWith("com.zoe")) {
                sb.append(element.toString() + "\n");
            }
        }
        return sb.toString();
    }

}
