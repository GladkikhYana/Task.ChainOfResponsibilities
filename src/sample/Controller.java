package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Player_R player1=new Player_R("Яна",0,5);
    public ActionChain_R action;
    public VBox vbox_quest;
    public ImageView image;
    public RadioButton r_action;
    public RadioButton r_event;
    public RadioButton r_gateways;
    public RadioButton r_sf;
    public RadioButton r_mf;
    public VBox vbox_imp;
    public Label l_count;
    public Label l_number;
    int i=0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vbox_quest.setVisible(false); 
        image.setImage(new Image("/image//рулетка.jpg"));
        l_count.setText(String.valueOf(player1.getCount())); 
    } 
    public void on_pay(ActionEvent actionEvent) 
    { 
        //оплата игры
        if(player1.getCount()>0)
        { 
            //если монетка есть в кошельке
            player1.addNumber(1); 
            //кинуть монетку в автомат
            player1.delCount(1); 
            //убрать монетку из кошелька
            l_count.setText(String.valueOf(player1.getCount()));
            l_number.setText(String.valueOf(player1.getNumber()));
        } 
        else 
            { 
                // бесплатнаяя игра
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Вы проиграли!");
                alert.setHeaderText("Но судьба дает Вам шанс сыграть еще раз бесплатно!");
                alert.show();     
                player1.addCount(1); 
                //даём игроку ещё монетку
                l_count.setText(String.valueOf(player1.getCount())); 
            } 
    }     
    public boolean init() 
    { 
        //проверка автомата на наличие монеток
        if (!player1.pay(1)) 
        { //если нет монеток
        Alert alert = new Alert(Alert.AlertType.INFORMATION); 
        alert.setHeaderText("Автомат пуст, кинь монетку!");
        alert.show(); 
        action = null; 
        image.setImage(new Image("/image//сундук.png"));
        return false; 
        } 
        else
            { 
                return true;
                //если есть
            }     
    } 
    public void on_start(ActionEvent actionEvent) 
    { 
        // обработчик событий кнопки Начать игру
        if (!init()) return ;
        //проверка ликвидности
        image.setImage(new Image("/image//сундук.png"));
        //загрузка автомата
        action = new ActionChain_R();
        //запуск механизма розыгрыша
        vbox_quest.setVisible(true); 
        //сделать видимым викторину
        l_number.setText(String.valueOf(player1.getNumber()));  
    }     
    public void on_fortune(ActionEvent actionEvent) 
    { 
        //обработчик событий кнопки Испытать удачу
        if (action == null) 
            return;
        //если цепочка обработки отсутствует
        i=action.chet();
        //генерируем случайное изображение элемента BPMN 
        image.setImage(new Image("/image//"+i+".jpg"));
        if(r_action.isSelected()==true && i==1) 
        { //если игрок угадал + 2 монеты
             action.process(1); 
             vbox_quest.setVisible(false); 
             player1.addCount(2); 
             l_count.setText(String.valueOf(player1.getCount())); 
        } 
        else if(r_event.isSelected()==true &&i==2) 
        { 
            action.process(1);
            vbox_quest.setVisible(false);
            player1.addCount(2); 
            l_count.setText(String.valueOf(player1.getCount()));
        } 
        else if(r_gateways.isSelected()==true &&i==3) 
        { 
            action.process(1);
            vbox_quest.setVisible(false);
            player1.addCount(2);
            l_count.setText(String.valueOf(player1.getCount()));
        } 
        else if(r_sf.isSelected()==true &&i==4)
        { 
            action.process(1); 
            vbox_quest.setVisible(false); 
            player1.addCount(2);
            l_count.setText(String.valueOf(player1.getCount())); 
        } 
        else if(r_mf.isSelected()==true &&i==5) 
        { 
            action.process(1); 
            vbox_quest.setVisible(false); 
            player1.addCount(2); 
            l_count.setText(String.valueOf(player1.getCount()));
        } 
        else
            { 
            action.processN();
            //если игрок не угадал + 0 монет
                vbox_quest.setVisible(false); 
                l_count.setText(String.valueOf(player1.getCount()));
                action=null;
                //завершить игру
            }
        }

    }