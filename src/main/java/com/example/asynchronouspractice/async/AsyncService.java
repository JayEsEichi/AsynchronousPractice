package com.example.asynchronouspractice.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    // Async 어노테이션을 적용시켜주고 AsyncConfig 파일에서 만들었던 threadPoolTaskExecutor를 매핑시켜주었다.
    // 매핑됨으로서 설정 파일 내용들이 이 메소드에 적용되어 기본 스레드풀에서 관리될 스레드의 개수는 3,
    // 스레드풀의 최대 사이즈는 30으로 지정된다.
    // 또한, 스레드들은 Queue에 넣어져서 우선 실행 순위가 발급되고 실행되는 데 그 Queue 크기를 100으로 설정되었다.
    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> print(String message) throws InterruptedException {
        System.out.println("Task Start - " + message);
        Thread.sleep(3000); // 스레드 잠깐의 휴식시간

        // Async 전용 응답 객체. 반환 타입이 Completable이므로 .completable 함수를 적용하여 반환한다.
        return new AsyncResult<>("AsyncResult-" + message).completable();

    }
}