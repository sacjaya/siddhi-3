package org.wso2.siddhi.query.api.query.input.pattern.element;

import org.wso2.siddhi.query.api.expression.constant.TimeConstant;
import org.wso2.siddhi.query.api.query.input.BasicSingleInputStream;


public class StreamElement implements PatternElement {
    private final BasicSingleInputStream basicSingleInputStream;
    private TimeConstant time;

    public StreamElement(BasicSingleInputStream basicSingleInputStream, TimeConstant time) {

        this.basicSingleInputStream = basicSingleInputStream;
        this.time = time;
    }

    public StreamElement(BasicSingleInputStream basicSingleInputStream) {

        this.basicSingleInputStream = basicSingleInputStream;
    }

    @Override
    public TimeConstant getWithin() {
        return time;
    }
}
