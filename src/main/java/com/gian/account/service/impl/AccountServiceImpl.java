package com.gian.account.service.impl;

import com.gian.account.model.response.AccountResponse;
import com.gian.account.service.IAccountService;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements IAccountService {
    @Override
    public Single<AccountResponse> getAccount(String s) {

            Observable<AccountResponse> personalAccount = Observable.just(
                    new AccountResponse("1111222233334441" + "XXX", 1000),
                    new AccountResponse("1111222233334442" + "XXX", 500),
                    new AccountResponse("1111222233334443" + "XXX", 1500))
                    .filter(x -> x.getAccountNumber().equals(s + "XXX"))
                    .concatMap(account -> Observable.just(account).delay(5, TimeUnit.SECONDS));

            return Single.fromObservable(personalAccount);
    }
}
