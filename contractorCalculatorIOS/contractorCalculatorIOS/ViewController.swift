//
//  ViewController.swift
//  contractorCalculator
//
//  Created by Edward Ong on 5/7/23.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var calculateButton: UIButton!
    
    @IBOutlet weak var laborInput: UITextField!
    
    @IBOutlet weak var materialInput: UITextField!
    
    @IBOutlet weak var subtotalLabel: UILabel!
    
    @IBOutlet weak var taxLabel: UILabel!
    
    @IBOutlet weak var totalLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
    }

    @IBAction func calculateButtonPressed(_ sender: Any) {
        let laborCost = Double(laborInput.text!) ?? 0.00
        let materialCost = Double(materialInput.text!) ?? 0.00
        
        subtotalLabel.text = String(format: "$%.2f", laborCost + materialCost)
        taxLabel.text = String(format: "$%.2f", 0.05 * (laborCost + materialCost))
        totalLabel.text = String(format: "$%.2f", (laborCost + materialCost) + (0.05 * (laborCost + materialCost)))
        
    }
    


}

