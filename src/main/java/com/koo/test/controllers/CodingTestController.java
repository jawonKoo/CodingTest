package com.koo.test.controllers;

import com.koo.test.enums.RecipientCountry;
import com.koo.test.enums.RemittanceCountry;
import com.koo.test.service.ExchangeRateService;
import com.koo.test.vo.CalculationVO;
import com.koo.test.vo.ExchangeRateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Slf4j
@Controller
public class CodingTestController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    /**
     * 환율 계산 화면
     * */
    @GetMapping("/")
    public String index(Model model) throws IOException {

        ExchangeRateVo exchangeRateVo = exchangeRateService.getExchangeRateInfo();

        model.addAttribute("remittanceCountry", RemittanceCountry.values()); //송금국가 목록
        model.addAttribute("recipientCountry", RecipientCountry.values()); //수취국가 목록
        model.addAttribute("exchangeRate",exchangeRateVo.getQuotes()); //USD환율 정보

        return "index";
    }

    /**
     * 환율 계산
     * @param calculationVO
     * @return
     * */
    @PostMapping("/calc")
    @ResponseBody
    public double calculation(CalculationVO calculationVO) throws IOException{

        ExchangeRateVo exchangeRateVo = exchangeRateService.getExchangeRateInfo();
        exchangeRateVo.getQuotes().setCalc(calculationVO);

        return exchangeRateVo.getQuotes().getCalc();
    }
}
