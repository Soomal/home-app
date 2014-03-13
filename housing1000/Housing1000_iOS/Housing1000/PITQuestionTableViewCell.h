//
//  PITQuestionTableViewCell.h
//  Housing1000
//
//  Created by student on 3/11/14.
//  Copyright (c) 2014 Group 3. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Question.h"

@interface PITQuestionTableViewCell : UITableViewCell <UIPickerViewDataSource,UIPickerViewDelegate>

@property (strong, nonatomic) IBOutlet UILabel *questionText;
@property (strong, nonatomic) IBOutlet UILabel *number;
@property (strong, nonatomic) IBOutlet UITextField *questionTextAnswer;
@property (strong, nonatomic) IBOutlet UIPickerView *questionSingleAnswer;
@property (strong, nonatomic) IBOutlet UIStepper *questionPickerAnswer;
@property (strong, nonatomic) Question *questionData;
//@property (strong, nonatomic) SubQuestion *subQuestionData;

@end