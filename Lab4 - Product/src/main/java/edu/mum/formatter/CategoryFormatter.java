package edu.mum.formatter;

import edu.mum.domain.Category;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {

    @Override
    public Category parse(String s, Locale locale) throws ParseException {
        Category category = null;

        try{

            category = new Category();
            category.setId(Integer.parseInt(s));

        }catch (Exception e){

            System.out.println("Bad Category Format");
        }

        return category;
    }

    @Override
    public String print(Category category, Locale locale) {
        return category.getName();
    }
}
