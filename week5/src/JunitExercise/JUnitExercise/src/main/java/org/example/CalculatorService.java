package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class CalculatorService {
    public int add(int a,int b){
        return a+b;
    }
}
