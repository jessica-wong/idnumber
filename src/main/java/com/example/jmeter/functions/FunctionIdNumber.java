package com.example.jmeter.functions;


import com.example.util.IdNumberGenerateUtil;
import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @Project: jmeter-functional
 * @Author: Jessica
 * @Create: 2022-10-09 16:00
 * @Desc：根据生日生成身份证号 **/

public class FunctionIdNumber extends AbstractFunction {
    private String birth;

    @Override
    public String execute(SampleResult sampleResult, Sampler sampler) throws InvalidVariableException {

        String result = "";

        result = IdNumberGenerateUtil.generate(birth);

        return result;
    }

    /**
     * 设置函数接收参数值，接收JMeter界面用户传递过来的参数
     * @param
     * @throws InvalidVariableException
     */
    @Override
    public void setParameters(Collection<CompoundVariable> collection) throws InvalidVariableException {
        //检查参数个数
        checkParameterCount(collection,0,1);
        //获取参数
        Object[] params = collection.toArray();
        //获取操作数1
        if (params.length>0) {
            CompoundVariable cvBirth = (CompoundVariable) params[0];
            this.birth = cvBirth.execute();
        }
    }

    /**
     * 函数名称
     * @return
     */
    @Override
    public String getReferenceKey() {
        return "__IDNumber";
    }

    /**
     * 函数参数描述，JMeter界面显示的参数说明
     * @return
     */
    public List<String> getArgumentDesc() {
        List<String> desc = new LinkedList<String>();
        desc.add("生日yyyymmdd");
        return desc;
    }
}
