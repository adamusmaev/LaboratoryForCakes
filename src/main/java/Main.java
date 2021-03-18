import entities.*;
import repositoryImpl.BaseRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        Base base = new Base("testBase");
        BaseRepositoryImpl baseRepository = new BaseRepositoryImpl();
        baseRepository.addBase(base);
        baseRepository.updateBase(base);
        Base base1 = (Base) baseRepository.getBaseById(base.getUuid());
        baseRepository.deleteBase(base);

    }
}
