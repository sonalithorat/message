package com.sonali.message.functions;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sonali.message.dto.AccountsMsgDto;

@Configuration
public class MessageFunctions {

	private static final Logger log = LoggerFactory.getLogger(MessageFunctions.class);

	@Bean
	public Function<AccountsMsgDto, AccountsMsgDto> email() {
		return accountsMsgDto -> {
			log.info("sending email with the details:" + accountsMsgDto.toString());
			return accountsMsgDto;
		};

	}
	
	@Bean
	public Function<AccountsMsgDto, Long> sms() {
		return accountsMsgDto -> {
			log.info("sending sms with the details:" + accountsMsgDto);
			return accountsMsgDto.accountNumber();
		};

	}
}
