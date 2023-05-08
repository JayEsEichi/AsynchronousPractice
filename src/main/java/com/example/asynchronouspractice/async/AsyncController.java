package com.example.asynchronouspractice.async;

import com.example.asynchronouspractice.request.AsyncRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@RequestMapping("/async")
@RestController
public class AsyncController {

    private final AsyncService asyncService;

    @PostMapping("/message/multithread/test")
    public void sendAsyncMessage(@RequestBody AsyncRequestDto asyncRequestDto) throws InterruptedException {

//        for(int i = 0 ; i < 10 ; i++){
//            asyncService.print(asyncRequestDto.getTester() + " " + i);
//        }

        for (int i = 1; i <= 5; i++) {
            CompletableFuture<String> completableFuture = asyncService.print(asyncRequestDto.getTester() + " " + i);
            completableFuture
                    .thenAccept(System.out::println) // thenAccept = 로직이 정상적으로 수행되었을 경우에 반환값을 println으로 출력.
                    .exceptionally(error -> { // exceptionally = 정상적으로 수행되지 않고 에러가 발생하면 error 라는 변수로 출력하고 return값은 null로 반환.
                        System.out.println(error.getMessage());
                        return null;
                    });
        }
    }

}
