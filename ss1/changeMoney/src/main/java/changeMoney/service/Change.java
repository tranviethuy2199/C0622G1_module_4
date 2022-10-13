package changeMoney.service;

import org.springframework.stereotype.Service;

@Service
public class Change implements IChange{
        @Override
        public double convert(double usd) {
                return usd * 23000;
        }
}
