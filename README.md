仿支付宝蚂蚁森林浮动按钮，点击水滴后向固定的地收回并慢慢消失，效果如下：
https://github.com/yangyong915/WaterDemo/blob/master/%E6%B5%AE%E5%8A%A8%E6%8C%89%E9%92%AE.gif

包含一个容器WaterContainer和自定义子控件WaterView，添加方式也相当简单，采用addChildView(this, relative, 1, posx, posy);方法；第一个参数为上下文，第二个参数为父布局，第三个参数为当前个数索引，第四个和第五个参数为当前add子控件的坐标轴，具体使用请参考demo
