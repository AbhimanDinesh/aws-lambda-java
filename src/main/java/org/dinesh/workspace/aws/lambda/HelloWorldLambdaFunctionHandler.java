package org.dinesh.workspace.aws.lambda;

import java.util.Objects;

import org.dinesh.workspace.aws.lambda.model.GreetingMessage;
import org.dinesh.workspace.aws.lambda.model.User;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloWorldLambdaFunctionHandler implements RequestHandler<User, GreetingMessage> {

	@Override
	public GreetingMessage handleRequest(User inputUser, Context context) {
		LambdaLogger logger = context.getLogger();

		logger.log("Entry");

		if (Objects.isNull(inputUser) || Objects.isNull(inputUser.getName())) {
			logger.log("Function invoked by anonymous user");
			return prepareMessage("");
		} else {
			logger.log("Function invoked by " + inputUser.getName());
		}

		logger.log("Exit");

		return prepareMessage(inputUser.getName());
	}

	private GreetingMessage prepareMessage(final String userName) {
		String message = "Welcome to AWS Lambda function"
				+ (userName != null && userName.length() > 0 ? (", " + userName) : "") + "!";
		return new GreetingMessage(message);
	}

}
