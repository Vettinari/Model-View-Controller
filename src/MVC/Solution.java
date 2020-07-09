package MVC;

import MVC.controller.Controller;
import MVC.model.MainModel;
import MVC.model.Model;
import MVC.view.EditUserView;
import MVC.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Controller controller = new Controller();
        UsersView usersView = new UsersView();
        Model model = new MainModel();
        EditUserView editUserView = new EditUserView();
        
        usersView.setController(controller);
        editUserView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireShowAllUsersEvent();
        usersView.fireOpenUserEditFormEvent(126L);
        editUserView.fireUserDeletedEvent(124L);
        editUserView.fireUserDataChangedEvent("Miłosz",254,1);
        usersView.fireShowDeletedUsersEvent();


    }
}