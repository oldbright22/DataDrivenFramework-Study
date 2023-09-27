package com.automationpractice.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor, Method testMethod) {
		//https://stackoverflow.com/questions/70956802/testng-7-0-1-deprecated-method-for-getretryanalyzer
		Class<? extends IRetryAnalyzer> retry = testannotation.getRetryAnalyzerClass();
		if (retry == null) {
			testannotation.setRetryAnalyzer(RetryFailedTestCases.class);
		}
	}

}
