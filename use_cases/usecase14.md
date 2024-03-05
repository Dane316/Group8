# USE CASE: 14   Produce a report on the top N populated cities in a region where N is provided by the user

## CHARACTERISTIC INFORMATION

### Goal in Context

As an Organization I want to produce a report on the top N populated cities in a region where N is provided by the user so that this population information is easy to access

### Scope

Organization

### Level

Primary task

### Preconditions

Database contains a list of all cities in the world and their population data per region

### Success End Condition

A report on top "N" populated cities in a region where "N" is provided by the user is generated

### Failed End Condition

No report is produced

### Primary Actor

User in the organization

### Trigger

A user in the organization requests top "N" populated cities in a region

## MAIN SUCCESS SCENARIO
1. User access system
2. User selects city report option
3. User enters value of "N" to represent the top "N" populated cities in a region
4. Report of top "N" populated cities in a region is generated
5. User extracts top "N" populated cities in a region information


## EXTENSIONS
2. User wants to generate a different report
   2a. Return to step 1
4. User wants to change the value of "N"
   4a. Return to step 3


## SUB-VARIATIONS

None

## SCHEDULE

**DUE DATE**: Release 1.0