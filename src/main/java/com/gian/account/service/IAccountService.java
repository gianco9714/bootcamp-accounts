package com.gian.account.service;

import com.gian.account.model.response.AccountResponse;
import io.reactivex.Single;

public interface IAccountService {

    Single<AccountResponse> getAccount(String s);
}
