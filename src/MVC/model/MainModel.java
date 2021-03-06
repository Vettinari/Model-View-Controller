package MVC.model;

import MVC.bean.User;
import MVC.model.service.UserService;
import MVC.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private UserService userService = new UserServiceImpl();
    private DataModel dataModel = new DataModel();

    @Override
    public DataModel getDataModel() {
        return dataModel;
    }

    @Override
    public void loadUsers() {
        //System.out.println("4");
        dataModel.setUsers(getAllUsers());
        dataModel.setDisplayDeletedUserList(false);
    }

    public void loadDeletedUsers() {
        dataModel.setUsers(userService.getAllDeletedUsers());
        dataModel.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        dataModel.setActiveUser(user);
    }

    public void deleteUserById(long id) {
        userService.deleteUser(id);
        dataModel.setUsers(getAllUsers());

    }

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        dataModel.setDisplayDeletedUserList(false);
        dataModel.setUsers(getAllUsers());
    }

    private List<User> getAllUsers() {
        dataModel.setUsers(userService.getUsersBetweenLevels(1,100));
        return userService.filterOnlyActiveUsers(dataModel.getUsers());
    }

}