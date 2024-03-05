# USE CASE: 2   Produce a report on all the countries in a continent organised by largest population to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

As an Organization I want to produce a report on all the countries in a continent organised by largest population to smallest so that this population information is easy to access.

### Scope

Organization

### Level

Primary task

### Preconditions

Database contains a list of all countries per continent and their population data

### Success End Condition

A report on all the countries in a continent organised by largest population to smallest is produced

### Failed End Condition

No report is produced

### Primary Actor

User in the organization

### Trigger

A user in the organization requests country population for a continent

## MAIN SUCCESS SCENARIO
1. User access system
2. User selects country report option
3. User request country population for a continent organised by largest population to smallest
4. User extracts population information for all countries in a continent  organised by largest population to smallest


## EXTENSIONS
2. User wants to generate a different report
   2a. Return to step 1
3. User wants to generate a country population report for a different continent 
    3a. Return to step 2


## SUB-VARIATIONS

None

## SCHEDULE

**DUE DATE**: Release 1.0