package model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class PositiveHandler_R extends Handler_R{
    public PositiveHandler_R(Handler_R processor) {
        super(processor);
    }
    public boolean process(Integer request)
    {
        if(request!=ActionChain_R.SUCCESS)
            return super.process(request);
        // не свой запрос передается дальше по цепочке
        else
        {
            //свой, обрабатывается здесь
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Вы выйграли!");
            alert.setHeaderText("Монетка у тебя, но всегда можно получить больше!");
            ButtonType replay = new ButtonType("Продолжить играть", ButtonBar.ButtonData.YES);
            ButtonType vacation = new ButtonType("Отдохнуть", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().clear(); alert.getButtonTypes().addAll(replay, vacation);
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().getButtonData() == ButtonBar.ButtonData.YES)
                return true;
            else
                return false;
        }
    }
}