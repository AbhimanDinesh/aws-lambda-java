package org.dinesh.workspace.aws.lambda;

import java.io.IOException;

import org.dinesh.workspace.aws.lambda.model.GreetingMessage;
import org.dinesh.workspace.aws.lambda.model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class HelloWorldLambdaFunctionHandlerTest {

	private static User inputUser;

	@BeforeClass
	public static void createInput() throws IOException {
		inputUser = new User("AWS User", "Cloud Engineer", "IT");
	}

	private Context createContext() {
		TestContext ctx = new TestContext();
		ctx.setFunctionName("Test function");
		return ctx;
	}

	@Test
	public void testHelloWorldLambdaFunctionHandler_case1() {
		HelloWorldLambdaFunctionHandler handler = new HelloWorldLambdaFunctionHandler();
		Context ctx = createContext();

		GreetingMessage result = handler.handleRequest(inputUser, ctx);

		Assert.assertEquals("Welcome to AWS Lambda function, AWS User!", result.getMessage());
	}

	@Test
	public void testHelloWorldLambdaFunctionHandler_case2() {
		HelloWorldLambdaFunctionHandler handler = new HelloWorldLambdaFunctionHandler();
		Context ctx = createContext();

		GreetingMessage result = handler.handleRequest(null, ctx);

		Assert.assertEquals("Welcome to AWS Lambda function!", result.getMessage());
	}
}
