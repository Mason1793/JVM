package cn.mason.code.jvm;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @Author zz
 * @Date
 **/
public class NameCheckProcessor extends AbstractProcessor {
    private NameCheck nameCheck;

    public void init(ProcessingEnvironment processingEnvironment){
        super.init(processingEnvironment);
        nameCheck=new NameCheck(processingEnvironment);
    }
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if(!roundEnv.processingOver()){
            for (Element element:roundEnv.getRootElements()){
                nameCheck.checkNames(element);
            }
        }

        return false;
    }
}
