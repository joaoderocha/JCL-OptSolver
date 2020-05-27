package kernel.common;

import org.junit.Assert;
import org.junit.Test;

import common.JclOptNonSingleton;
import common.JclOptObject;

public class JclOptNonSingletonTest {

    public class nonSingletonClass extends JclOptNonSingleton {
        private int a = 5;

    
        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public JclOptObject getInstance() {
            return new nonSingletonClass();
        }
    }

    @Test
    public void factoryBuilding() {
            nonSingletonClass minhaClasse = new nonSingletonClass();
            nonSingletonClass minhaClasse2 = new nonSingletonClass();
            minhaClasse.setA(10);    
            Assert.assertEquals(minhaClasse.getA(), 10);
            Assert.assertEquals(minhaClasse2.getA(), 5);
    }
}