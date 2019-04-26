package cn.mason.code.jvm;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner6;

import static javax.lang.model.element.ElementKind.ENUM_CONSTANT;
import static javax.lang.model.element.ElementKind.FIELD;
import static javax.lang.model.element.ElementKind.INTERFACE;

/**
 * @Author zz
 * @Date
 **/
@SupportedAnnotationTypes("*")
public class NameCheck {
    private final Messager messager;
    NameCheckScanner nameCheckScanner=new NameCheckScanner();
    NameCheck(ProcessingEnvironment processingEnvironment){
        this.messager = processingEnvironment.getMessager();
    }
    public void checkNames(Element element){
        nameCheckScanner.scan(element);
    }

    private class NameCheckScanner extends ElementScanner6<Void,Void>{
        @Override
        public Void visitVariable(VariableElement e,Void p){
            if(e.getKind() == ENUM_CONSTANT || e.getConstantValue() != null || heuristicallyConstant(e)){

            }else {

            }
            return null;
        }
        private boolean heuristicallyConstant(VariableElement e){
            if(e.getEnclosingElement().getKind() == INTERFACE){
                return false;
            }else if(e.getKind() == FIELD ){
                return true;
            }else {
                return false;
            }
        }
    }
}
