package com.gian.account.controller;

import com.gian.account.model.response.AccountResponse;
import com.gian.account.service.IAccountService;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@Slf4j
@Validated
@RestController
@RequestMapping("/core")
@Api(value = "AccountController", produces = "application/json", tags = { "Account Controller" })
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @ApiOperation(value = "Obtener Cuentas", tags = { "Account Controller" })
    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta Éxitosa", response = AccountResponse.class),
            @ApiResponse(code= 500, message = "500 Error Internal.")})
    public Single<AccountResponse> getAccount(@RequestParam String cardNumber){

        log.info("Controller: Get Account with Card Number: " + cardNumber);
        return accountService.getAccount(cardNumber);
    }
}
