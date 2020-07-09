package MVC.view;

import MVC.controller.Controller;
import MVC.model.DataModel;

public class EditUserView implements View{
    private Controller controller;

    @Override
    public void refresh(DataModel dataModel) {
        System.out.println("User to be edited:");
        System.out.println("\t" + dataModel.getActiveUser().toString());
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller=controller;
    }

    public void fireUserDeletedEvent(long id) {
        controller.onDeleteUser(id);
    }

    public void fireUserDataChangedEvent(String name, long id, int level){
        controller.onChangeUserData(name,id,level);
    }

}
