package MVC.view;

import MVC.controller.Controller;
import MVC.model.DataModel;

public class UsersView implements View {
    private Controller controller;

    @Override
    public void refresh(DataModel dataModel) {
        if (dataModel.isDisplayDeletedUserList())
            System.out.println("All deleted users:");
        else
            System.out.println("All users:");
        dataModel.getUsers().forEach(user -> System.out.println("\t" + user));
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireShowAllUsersEvent() {
        controller.onShowAllUsers();
    }

    public void fireShowDeletedUsersEvent() {
        controller.onShowAllDeletedUsers();
    }

    public void fireOpenUserEditFormEvent(long id) {
        controller.onOpenUserEditForm(id);
    }

}