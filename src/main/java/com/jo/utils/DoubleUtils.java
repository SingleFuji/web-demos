package com.jo.utils;

import java.math.BigDecimal;

public class DoubleUtils {

	public static double multi(double d1, double d2){
		return BigDecimal.valueOf(d1).multiply(BigDecimal.valueOf(d2)).doubleValue();
	}
}
