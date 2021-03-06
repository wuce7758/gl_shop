//
//  UIFactory.m
//  Glshop
//
//  Created by River on 14-11-13.
//  Copyright (c) 2014年 appabc. All rights reserved.
//

#import "UIFactory.h"

@interface UIFactory ()

@end

@implementation UIFactory

+ (UIView *)createPromptViewframe:(CGRect)frame tipTitle:(NSString *)title {
    UIImageView *imageview = [[UIImageView alloc] initWithFrame:frame];
    imageview.userInteractionEnabled = YES;
    UIImage *image = [UIImage imageNamed:@"attestation_prompt_background"];
    image = [image resizableImageWithCapInsets:UIEdgeInsetsMake(10, 10, 10, 10) resizingMode:UIImageResizingModeTile];
    imageview.image = image;
    
    UILabel *label = [[UILabel alloc] initWithFrame:CGRectMake(imageview.vwidth/2-50, 10, 100, 25)];
    label.text = @"温馨提示";
    if (title) {
        label.text = title;
    }
    label.textAlignment = NSTextAlignmentCenter;
    label.font = [UIFont boldSystemFontOfSize:FONT_14];
    label.textColor = ColorWithHex(@"#36a830");
    [imageview addSubview:label];
    
    return imageview;
}

+ (UILabel *)createUnitLabel:(NSString *)text withFont:(UIFont *)font unitType:(UnitTextType)type {
    return [UIFactory createUnitLabel:text withFont:font unitType:type cellHeight:kCellDefaultHeight];
}

+ (UILabel *)createUnitLabel:(NSString *)text
                    withFont:(UIFont *)font
                    unitType:(UnitTextType)type
                  cellHeight:(float)height {
    NSString *unittext;
    if (type == unint_yuan) {
        unittext = @"(单位:元)";
    }else if (type == unint_dun) {
        unittext = @"(单位:吨)";
    }else if (type == unint_per_dun_money) {
        unittext = @"(单位:元/吨)";
    }
    UILabel *unitlabel = [UILabel labelWithTitle:unittext];
    unitlabel.font = font;
    unitlabel.textColor = [UIColor grayColor];
    CGSize size = [Utilits labelSizeCalculte:font labelText:text];
    unitlabel.frame = CGRectMake(size.width+kCellLeftEdgeInsets, 0, 100, height);
    return unitlabel;
}

+ (UIButton *)createBtn:(NSString *)imageName bTitle:(NSString *)title bframe:(CGRect)frame {
    UIImage *image = [UIImage imageNamed:imageName];
    image = [image resizableImageWithCapInsets:UIEdgeInsetsMake(10, 10, 10, 10) resizingMode:UIImageResizingModeStretch];
    
    UIButton *btn = [UIButton buttonWithType:UIButtonTypeCustom];
    [btn setBackgroundImage:image forState:UIControlStateNormal];
    [btn setTitle:title forState:UIControlStateNormal];
    btn.frame = frame;
    
    return btn;
}

@end
