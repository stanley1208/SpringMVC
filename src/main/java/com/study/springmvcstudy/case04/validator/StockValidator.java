package com.study.springmvcstudy.case04.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.study.springmvcstudy.case04.entity.Stock;

import yahoofinance.YahooFinance;

@Component
public class StockValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 驗證
		return Stock.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Stock stock = (Stock) target;
		// 基礎驗證
		ValidationUtils.rejectIfEmpty(errors, "symbol", "stock.symbol.empty");
		ValidationUtils.rejectIfEmpty(errors, "price", "stock.price.empty");
		ValidationUtils.rejectIfEmpty(errors, "amount", "stock.amount.empty");

		// 進階驗證
		yahoofinance.Stock yStock = null;
		try {
			yStock = YahooFinance.get(stock.getSymbol());
			// 昨收
			double previousClose = yStock.getQuote().getPreviousClose().doubleValue();

			// 要驗證的欄位資料
			double price = stock.getPrice();
			int amount = stock.getAmount();

			// 1. 買進價格必須是昨日收盤價的±10%之間 ( {0} ~ {1} )
			if (price < previousClose * 0.9 || price > previousClose * 1.1) {
				errors.rejectValue("price", "stock.price.range");
			}
			// 2. 買進股數必須大於或等於1000
			if (amount < 1000) {
				errors.rejectValue("amount", "stock.amount.notenough");

			}
			if (amount % 1000 != 0) {
				errors.rejectValue("amount", "stock.amount.range");

			}
			// 3. 買進股數必須是1000的倍數(1000股 = 1張)
		} catch (Exception e) {
			e.printStackTrace();
			if (yStock == null) {
				// rejectValue 的錯誤訊息可以支援 .properties
				errors.rejectValue("symbol", "stock.symbol.notfound");
			}
		}
	}

}
