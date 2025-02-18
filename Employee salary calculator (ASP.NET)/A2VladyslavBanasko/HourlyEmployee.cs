﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace A2VladyslavBanasko
{
    class HourlyEmployee : Employee
    {
        // hours worked and hourly wage.
        public override int HoursWorked { get; protected set; }

        public override double HourlyWage { get; protected set; }

        public HourlyEmployee(string name, EmployeeType type, int hours, double wage) : base(name, type)
        {
            HoursWorked = hours;
            HourlyWage = wage;
        }

        public override double GrossEarnings
        {
            get
            {
                if (HoursWorked <= 40)
                {
                    return HoursWorked * HourlyWage;
                }
                else
                    return (40 * HourlyWage) + (HoursWorked - 40) * HourlyWage * 1.5;
            }
        }
    }

}

