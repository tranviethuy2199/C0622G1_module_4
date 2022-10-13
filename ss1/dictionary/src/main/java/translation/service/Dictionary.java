package translation.service;

import org.springframework.stereotype.Service;
import translation.model.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Dictionary implements IDictionary{
    private static final Map<String,String> words = new HashMap<>();
    static {
       words.put("hello","xin chao");
       words.put("thieu nang","thanh hai");
       words.put("ra de","the son");
    }
    @Override
    public String findWord(String word) {
        return words.get(word);
    }
}
