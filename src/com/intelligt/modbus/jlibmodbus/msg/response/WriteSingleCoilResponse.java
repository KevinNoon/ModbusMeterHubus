package com.intelligt.modbus.jlibmodbus.msg.response;

import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.exception.ModbusNumberException;
import com.intelligt.modbus.jlibmodbus.utils.ModbusFunctionCode;

/*
 * Copyright (C) 2016 "Invertor" Factory", JSC
 * [http://www.sbp-invertor.ru]
 *
 * This file is part of JLibModbus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Authors: Vladislav Y. Kochedykov, software engineer.
 * email: vladislav.kochedykov@gmail.com
 */
final public class WriteSingleCoilResponse extends WriteSingleRegisterResponse {

    public WriteSingleCoilResponse() {
        super();
    }

    public boolean getCoil() {
        return Modbus.toCoil(getValue());
    }

    public void setCoil(boolean coil) throws ModbusNumberException {
        setValue(Modbus.fromCoil(coil));
    }

    @Override
    protected boolean checkValue() {
        return getValue() == Modbus.COIL_VALUE_ON || getValue() == Modbus.COIL_VALUE_OFF;
    }

    @Override
    public int getFunction() {
        return ModbusFunctionCode.WRITE_SINGLE_COIL.toInt();
    }
}
