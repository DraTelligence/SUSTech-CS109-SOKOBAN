//package view.game;
//
//import java.awt.Image;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import model.MapComponents;
//
//@SuppressWarnings("FieldMayBeFinal")
//public class MapComponent extends JLabel {
//    private final int width, height;
//    private MapComponents mapComponent;
//    private final int firstFolderNum, secondFolderNum;
//
//    public MapComponent(MapComponents mapComponent, int stageNum, int width, int height) {
//        this.mapComponent = mapComponent;
//        this.firstFolderNum = stageNum % 3;
//        this.secondFolderNum = stageNum % 2;
//        this.width = width;
//        this.height = height;
//
//        setIcon();
//    }
//
//    private String getUrl() {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("data\\icons\\");
//        switch (mapComponent) {
//            case BOX -> sb.append("Crates\\crates").append(firstFolderNum).append("\\crate").append(secondFolderNum)
//                    .append(".png");
//            case BOX_ON_TARGET -> sb.append("Crates\\crates").append(firstFolderNum).append("\\crate")
//                    .append(secondFolderNum).append(".png");
//            case SPACE -> sb.append("Ground\\ground").append(firstFolderNum).append("ground.png");
//            case TARGET -> sb.append("Ground\\ground").append(firstFolderNum).append("ground_with_target.png");
//            case WALL -> sb.append("Wall\\wall").append(firstFolderNum).append(".png");
//        }
//        return sb.toString();
//    }
//
//    public void setMapComponent(MapComponents component) {
//        this.mapComponent = component;
//        setIcon();
//
//        repaint();
//    }
//
//    private void setIcon() {
//        ImageIcon icon = new ImageIcon(getUrl());
//        icon.setImage(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
//        this.setIcon(icon);
//    }
//}
