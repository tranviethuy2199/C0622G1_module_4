package Computer.service;

import org.springframework.stereotype.Service;

@Service
public class ComputerService implements IComputerService {
    @Override
    public double summation(double a, double b) {
        return a + b ;
    }

    @Override
    public double subtraction(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) {
        return a * b;
    }

    @Override
    public double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("không đúng phép toán");
        }
        return a / b;
    }


}
