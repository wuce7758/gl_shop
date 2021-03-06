//
//  PublicInfoViewController.m
//  Glshop
//
//  Created by River on 14-12-2.
//  Copyright (c) 2014年 appabc. All rights reserved.
//

#import "PublicInfoViewController.h"
#import "CompanyAuthViewController.h"

@interface PublicInfoViewController ()

@property (nonatomic, strong) UIWebView *webView;

@end

@implementation PublicInfoViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void)loadSubViews {
    UILabel *tipLabel = [UILabel labelWithTitle:@"您正在发布信息，您可以选择致电平台客服免费帮您发布信息或自己手动输入发布信息。"];
    tipLabel.numberOfLines = 3;
    tipLabel.textAlignment = NSTextAlignmentCenter;
    tipLabel.frame = CGRectMake(15, 30, self.view.vwidth-30, 80);
    tipLabel.font = [UIFont systemFontOfSize:18.f];
    tipLabel.textColor = C_BLACK;
    [self.view addSubview:tipLabel];
    
    UIButton *btnPhone = [UIFactory createBtn:@"登录-未触及状态" bTitle:@"致电平台代为发布信息" bframe:CGRectMake(10, tipLabel.vbottom+30, self.view.vwidth-20, 40)];
    [btnPhone addTarget:self action:@selector(callTel) forControlEvents:UIControlEventTouchUpInside];
    btnPhone.backgroundColor = [UIColor orangeColor];
    [self.view addSubview:btnPhone];
    
    UIButton *btnPublic = [UIFactory createBtn:@"注册-正常状态" bTitle:@"自己发布信息" bframe:CGRectMake(btnPhone.vleft, btnPhone.vbottom+20, btnPhone.vwidth, btnPhone.vheight)];
    [btnPublic addTarget:self action:@selector(publicInfo:) forControlEvents:UIControlEventTouchUpInside];
    btnPublic.backgroundColor = CJBtnColor;
    [self.view addSubview:btnPublic];
}

- (void)publicInfo:(UIButton *)button {
    CompanyAuthViewController *vc = [mainStoryBoard instantiateViewControllerWithIdentifier:@"CompanyAuthViewControllerId"];
    [self.navigationController pushViewController:vc animated:YES];
}

- (void)callTel {
    // 提示：不要将webView添加到self.view，如果添加会遮挡原有的视图
    // 懒加载
    if (_webView == nil) {
        _webView = [[UIWebView alloc] init];
    }
    NSLog(@"%p", _webView);
    
    //    _webView = [[UIWebView alloc] initWithFrame:self.view.bounds];
    //    [self.view addSubview:_webView];
    
    NSURL *url = [NSURL URLWithString:kAppTel];
    NSURLRequest *request = [NSURLRequest requestWithURL:url];
    
    [_webView loadRequest:request];
}// 致电客服

@end
